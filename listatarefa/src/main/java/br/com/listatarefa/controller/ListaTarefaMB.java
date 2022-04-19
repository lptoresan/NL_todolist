package br.com.listatarefa.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.listatarefa.model.ListaTarefa;
import br.com.listatarefa.service.ListaTarefaService;
import br.com.listatarefa.utility.Message;
import br.com.listatarefa.utility.NegocioException;

@Named("tarefa")
@ViewScoped
public class ListaTarefaMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ListaTarefa listatarefa;

	@Inject
	private ListaTarefaService service;

	private List<ListaTarefa> tarefas;

	@PostConstruct
	public void carregar() {
		tarefas = service.todosAsTarefas();
	}

	public void adicionarTarefa() {
		try {
			service.salvar(listatarefa);
			listatarefa = new ListaTarefa();
			carregar();	
			Message.okmsg("Sucesso ao cadastrar!");
		} catch (NegocioException e) {
			Message.erro(e.getMessage());
		}
	}

	public void excluir() {
		try {
			service.remover(listatarefa);
			carregar();
			Message.okmsg("A tarefa foi excluída!");
		} catch (NegocioException e) {
			Message.erro(e.getMessage());
		}
	}

	public ListaTarefa getListatarefa() {
		return listatarefa;
	}

	public void setListatarefa(ListaTarefa listatarefa) {
		this.listatarefa = listatarefa;
	}

	public List<ListaTarefa> getTarefas() {
		return tarefas;
	}
}
