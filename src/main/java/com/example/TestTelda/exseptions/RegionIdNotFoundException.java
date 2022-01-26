
package com.example.TestTelda.exseptions;

/**
 *
 * @author Уфилин Д.В.
 */
public class RegionIdNotFoundException extends RuntimeException{
    
    public RegionIdNotFoundException()
    {
        super("Регион с указанным id не найден");
    }
    
}
