package br.com.listatarefa.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import br.com.listatarefa.model.ListaTarefa;
import br.com.listatarefa.utility.NegocioException;
import br.com.listatarefa.dao.DAO;

public class ListaTarefaService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DAO<ListaTarefa> dao;
	
	public void salvar (ListaTarefa lf) throws NegocioException {
		
		if(lf.getNome().length() < 5) {
			throw new NegocioException("A tarefa precisa conter ao menos cinco letras.");
		}
		
		dao.salvar(lf);
	}
	
	public void remover (ListaTarefa lf) throws NegocioException {
		dao.remover(ListaTarefa.class, lf.getId());
	}
	
	public List<ListaTarefa> todosAsTarefas (){
		return dao.buscarTodos("select lf from ListaTarefa lf order by lf.nome");
	}

}
