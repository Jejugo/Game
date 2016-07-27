/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JefsLoloModel;

/**
 *
 * @author JeffGoes    
 */
public class CaveiraFactory{
  
     public static Elemento getElemento(String sNomeImagePNG,  String elemento)
  {
    if ( elemento.equals("caveiraHorizontal"))
      return new CaveiraHorizontal(sNomeImagePNG);
    else if ( elemento.equals("caveiraVertical"))
      return new CaveiraVertical(sNomeImagePNG);
  
    throw new IllegalArgumentException("Elemento inexistente");
  }
}
