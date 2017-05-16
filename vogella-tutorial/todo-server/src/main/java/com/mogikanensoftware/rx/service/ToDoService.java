package com.mogikanensoftware.rx.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mogikanensoftware.rx.vo.ItemStatus;
import com.mogikanensoftware.rx.vo.ToDoItem;

@RestController
public class ToDoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ToDoService.class);

	private final List<ToDoItem> items = new ArrayList<>();

	public ToDoService() {
		super();

		for (int i = 0; i < 10; i++) {

			Date date = new Date();
			ItemStatus status;
			if (i % 2 == 0) {
				status = ItemStatus.created;
			} else if (i % 3 == 0) {
				status = ItemStatus.scheduled;
			} else if (i % 3 == 0) {
				status = ItemStatus.complete;
			} else {
				status = ItemStatus.inProgress;
			}

			items.add(new ToDoItem(i, "Name " + i, "Desc " + i, date, date, status));
		}

	}

	@GetMapping("/api/v1/todoitems/")
	public List<ToDoItem> listAll() throws ToDoServiceException {

		// emulate load
		try {
			LOGGER.info("Working hard to retrive the data...");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			LOGGER.error(e.getMessage(), e);
			throw new ToDoServiceException(e.getMessage(), e);
		}
		LOGGER.info("Got the list - returning result...");
		return items;
	}

	@GetMapping("/api/v1/todoitems/{id}")
	public ToDoItem getToDoItemById(final @PathVariable("id") long id) throws ToDoServiceException {

		List<ToDoItem> allItems = this.listAll();
		List<ToDoItem> filteredById = allItems.stream().filter((item) -> {
			return item.getId() == id;
		}).collect(Collectors.toList());
		LOGGER.info(String.format("Got item by id -> %s, total els->%d", id, filteredById.size()));
		
		ToDoItem  rs = null;
		if(!filteredById.isEmpty()){
			rs = filteredById.get(0);
		}
		LOGGER.info(String.format("rs->%s", rs));
		
		return rs;
	}

	@GetMapping("/api/v1/todoitems/status/{ItemStatus}")
	public List<ToDoItem> listByStatus(final @PathVariable("ItemStatus") ItemStatus status)
			throws ToDoServiceException {

		List<ToDoItem> allItems = this.listAll();
		List<ToDoItem> filteredByStatus = allItems.stream().filter((item) -> {
			return item.getStatus().equals(status);
		}).collect(Collectors.toList());
		LOGGER.info(String.format("Got filtered list by status -> %s", status));
		return filteredByStatus;
	}

}
