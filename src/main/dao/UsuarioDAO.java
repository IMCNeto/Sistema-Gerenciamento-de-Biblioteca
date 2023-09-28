package main.dao;

import main.Interfaces.UsuarioCRUD;
import main.model.Emprestimo;
import main.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements UsuarioCRUD {

    private ArrayList<Usuario> lista;
    private int prox_id;

    public UsuarioDAO(){

        this.lista = new ArrayList<>();
        this.prox_id = 0;

    }

    private int getProx_id() {
        return this.prox_id++;
    }

    @Override
    public Usuario create(Usuario obj) {
        this.lista.add(obj);
        return obj;
    }

    @Override
    public Usuario update(Usuario obj) throws Exception {
        try {
            int index = this.lista.indexOf(obj);
            this.lista.set(index, obj);
            return obj;
        }
        catch (Exception e){
            throw new Exception("Erro ao Atualizar Usuário");
        }
    }

    @Override
    public List<Usuario> usuariosBloqueados(List<Emprestimo> emp) throws Exception {
        try {
            List<Usuario> listaUsuariosBloqueados = new ArrayList<Usuario>();
            for(Emprestimo obj : emp){
                listaUsuariosBloqueados.add(obj.getUsuario());
                update(obj.getUsuario());
            }
            return listaUsuariosBloqueados;
        }
        catch (Exception e){
            throw new Exception("Erro ao buscar lista de usuários bloqueados");
        }

    }
    @Override
    // lê toda lista;
    public ArrayList<Usuario> read() {
        return this.lista;
    }

    @Override
    public Usuario readID(int id) {
        for (Usuario usuario : this.lista){
            if (usuario.getNum_id() == id){
                return usuario;
            }

        }
        return null;
    }

    @Override
    //Deleta um objeto;
    public void delete(Usuario obj) throws Exception {
        try {
            this.lista.remove(obj);
        }
        catch (Exception e){
            throw new Exception("Erro ao Deletar Usuário");
        }

    }

    @Override
    //limpa toda lista;
    public void deleteMany() {
        this.lista.clear();
        this.prox_id = 0;
    }
}
