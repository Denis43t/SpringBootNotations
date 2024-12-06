package org.example.springbootnotations.controler;

import org.example.springbootnotations.model.Note;
import org.example.springbootnotations.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoteController {
    @Autowired
    NoteService noteService;
    @GetMapping(value = "note/list")
    public ModelAndView getNotes() {
        ModelAndView result = new ModelAndView("note/list");
        result.addObject("notes", noteService.listAll());
        return result;
    }
    @PostMapping("/note/delete")
    public String deleteNote(@RequestParam("id") Long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }
    @PostMapping("/note/edit")
    public String PostEditNote(@RequestParam("id") Long id,
                           @RequestParam("title") String title,
                           @RequestParam("content") String content) {
        noteService.update(Note.builder()
                        .id(id)
                        .title(title)
                        .content(content)
                .build());
        return "redirect:list";
    }
    @GetMapping("/note/edit")
    public String GetEditNote(@RequestParam("id") Long id, Model model) {
        Note note = noteService.getById(id);
        model.addAttribute("note", note);
        return "note/edit";
    }

}
