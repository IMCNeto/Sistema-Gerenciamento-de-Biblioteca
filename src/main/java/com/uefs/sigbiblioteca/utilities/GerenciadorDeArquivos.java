package com.uefs.sigbiblioteca.utilities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**Classe que contém os métodos para leitura e gravação de arquivos;
 * @author Ilson Neto e Jhessé Campos;
 *@version 1.0;
 */
public class GerenciadorDeArquivos {
    public static final File DIRETORIO = new File("data");

    public static File criar_arquivo(String caminhoArquivo) {
        if (!DIRETORIO.exists()) {
            DIRETORIO.mkdir();
        }
        File arquivo = new File(DIRETORIO + "/" + caminhoArquivo + ".ji");

        if (!arquivo.exists()){
            try {
                arquivo.createNewFile();
            } catch (IOException e) {
                return null;
            }
        }
        return arquivo;
    }

    public static <E extends Serializable> boolean salvar_arquivo(File nomeArquivo, List<E> lista){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            out.writeObject(lista);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static <E extends Serializable> ArrayList<E> carregar_arquivo(File nomeArquivo){
        ArrayList<E> lista;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            lista = (ArrayList<E>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            lista = new ArrayList<>();
        }

        return lista;
    }
    }




