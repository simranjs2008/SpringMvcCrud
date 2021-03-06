package crudspringmvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import crudspringmvc.model.Record;
import crudspringmvc.service.RecordJpaService;

@Controller
public class RecordController {

	//@Autowired
	//RecordService recordService;
	
	@Autowired
	RecordJpaService recordJpaService;
	
	@RequestMapping("")
	public String root() {
		return "redirect:/showRecords";
	}
	
	@RequestMapping("/showRecords")
	public String showRecord(Model model) {
		//List<Record> records = (ArrayList<Record>) recordService.findAllRecord();
		List<Record> records = (ArrayList<Record>) recordJpaService.getRecords();
		
		System.out.println(records.size());
		model.addAttribute("recordSize", records.size());
		model.addAttribute("records", records);
		return "showRecords";
	}
	
	@RequestMapping("/createRecord")
	public String createRecord(Model model) {
		model.addAttribute("record", new Record());
		return "createRecord";
	}
	
	@RequestMapping(path = "/addRecord", method = RequestMethod.POST)
	public String createRecord(@ModelAttribute @Valid Record record, BindingResult result) {
		System.out.println(record);
		if(result.hasErrors()) {
			return "createRecord";
		}
		
		//recordService.addRecord(record);
		recordJpaService.saveRecord(record);
		
		return "redirect:/showRecords";
	}
	
	@RequestMapping("/editRecord/{id}")
	public String editRecord(@PathVariable("id") int id, Model model) {
		System.out.println(id);
		//Record result = recordService.findById(id);
		Optional<Record> result = recordJpaService.findById(id);
		model.addAttribute("record", result);
		System.out.println(result);
		return "editRecord";
	}
	
	@RequestMapping(path = "/editRecord/updateRecord", method = RequestMethod.POST)
	public String updateRecord(@ModelAttribute @Valid Record record,BindingResult result) {
		System.out.println("record to be updated" + record);
		if(result.hasErrors()) {
			return "editRecord";
		}
		//recordService.updateRecord(record);
		recordJpaService.updateRecord(record);
		return "redirect:/showRecords";
	}
	
	@RequestMapping(path = "/deleteRecord/{id}", method = RequestMethod.POST)
	public String deleteRecord(@PathVariable("id") int id) {
		System.out.println("record id to be delete" + id);
		recordJpaService.deleteRecord(id);
		//recordService.deleteRecord(id);
		return "redirect:/showRecords";
	}
}
