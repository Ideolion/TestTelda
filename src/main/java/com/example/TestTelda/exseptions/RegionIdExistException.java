package com.example.TestTelda.exseptions;

/**
 *
 * @author Уфилин Д.В.
 */
public class RegionIdExistException extends RuntimeException {

    /**
     *
     * Исключение, которое выбрасывается в случае попытки добавить в базу данных регион,
     * который уже существует в базе. Проверка ведется по ID региона
     */

    public RegionIdExistException() {
        super("Регион с таким id уже существует");
    }

}
