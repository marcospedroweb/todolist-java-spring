package br.com.marcospedroweb.todolist.utils;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class Utils {

  public static void copyNonNullProperties(Object source, Object target) {
    BeanUtils.copyProperties(source, target, getNullPropertyNames(source)); // Copia as prop de um obj para outro obj
  }

  // Retorna propriedades nulas de um obj
  public static String[] getNullPropertyNames(Object source) {
    final BeanWrapper src = new BeanWrapperImpl(source); // Interface para acessar as propriedades de um obj
    PropertyDescriptor[] pds = src.getPropertyDescriptors();// Array com todas propriedades do obj
    Set<String> emptyNames = new HashSet<>();

    // For de iteração, retornando a propriedade com valor null
    for (PropertyDescriptor pd : pds) {
      Object srcValue = src.getPropertyValue(pd.getName()); // pega propriedades, o getters e setters
      if (srcValue == null) {
        emptyNames.add(pd.getName());
      }
    }

    String[] result = new String[emptyNames.size()]; // Transforma em array
    return emptyNames.toArray(result);
  }
}
