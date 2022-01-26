package com.example.TestTelda.exseptions;

/**
 *
 * @author Уфилин Д.В.
 */
public class RegionIdNotFoundException extends RuntimeException {

    /**
     * Исключение, которое выбрасывается в случае попытки добавить запросить в
     * базе регион с несуществующим ID
     */
    public RegionIdNotFoundException() {
        super("Регион с указанным id не найден");
    }

}
