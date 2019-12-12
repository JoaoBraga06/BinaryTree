/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 * <h3>
 * ESTG - Escola Superior de Tecnologia e Gestão<br>
 * IPP - Instituto Politécnico do Porto<br>
 * LEI - Licenciatura em Engenharia Informática<br>
 * ED - Estrutura de Dados<br>
 * </h3>
 * <p>
 * <strong>Author: </strong><br>
 * Joao Brito<br>
 * <strong>Description: </strong><br>
 * Exception for the current number of modifications.
 * </p>
 *
 */
public class CurrentModificationException extends Exception {

    /**
     * Creates a new instance of <code>CurrentModificationException</code>
     * without detail message.
     */
    public CurrentModificationException() {
    }

    /**
     * Constructs an instance of <code>CurrentModificationException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public CurrentModificationException(String msg) {
        super(msg);
    }
}
