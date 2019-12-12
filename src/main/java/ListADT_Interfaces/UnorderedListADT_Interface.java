/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListADT_Interfaces;

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
 * Interface for the unordered lists.
 * </p>
 *
 * @param <T>
 */
public interface UnorderedListADT_Interface<T> extends ListADT_Interface<T> {
    public void addToFront(T element);
    
    public void addToRear(T element);
    
    public void addAfter(T element, T elementToAdd);
}
