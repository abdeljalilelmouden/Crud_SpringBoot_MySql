package org.sid.stagiaire.controller;

import javax.validation.Valid;

import org.sid.stagiaire.dao.StagiaireRepository;
import org.sid.stagiaire.entities.Stagiaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StagiaireController {

	@Autowired
	private StagiaireRepository stagiaireRepository;

	@GetMapping(path = "/stagiaires")
	public String list(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "7") int size,
			@RequestParam(name = "mc", defaultValue = "") String mc) {
		Page<Stagiaire> pagesStagiaires = stagiaireRepository.findByNomContains(mc, PageRequest.of(page, size));
		model.addAttribute("stagiaires", pagesStagiaires.getContent());
		model.addAttribute("pages", new int[pagesStagiaires.getTotalPages()]);
		model.addAttribute("pageCourant", page);
		model.addAttribute("mc", mc);
		return "stagiaires";
	}

	@GetMapping(path = "/deleteStagiaire")
	public String delete(Long id) {
		stagiaireRepository.deleteById(id);
		return "redirect:/stagiaires";
	}

	@GetMapping("/formAjouteStagiaire")
	public String formAjouteStagiaire(Model model) {
		model.addAttribute("stagiaire", new Stagiaire());
		return "ajoute";
	}

	/*
	 * @GetMapping("/login") public String login() { return "login"; }
	 * 
	 * @GetMapping("/logout") public String logout() { return "login"; }
	 */
	@PostMapping(path = "/saveStagiaire")
	public String saveStagiaire(@Valid Stagiaire stagiaire, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) return "ajoute";
		stagiaireRepository.save(stagiaire);
		return "stagiaires";
	}

	@GetMapping("/formEditStagiaire")
	public String editStagiaire(Long id, Model model) {
		Stagiaire stagiaire = stagiaireRepository.findById(id).get();
		model.addAttribute("stagiaire", stagiaire);
		return "edit";
	}
	@PostMapping(path = "/updateStagiaire")
	public String updateStagiaire(@Valid Stagiaire etudiant, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "ajoute";
		stagiaireRepository.save(etudiant);
		return "stagiaires";
	}
}
