package com.example.TestTelda.exseptions;

/**
 *Класс для обработки исключения
 * @author Уфилин Д.В.
 */
public class RegionIdExistException extends RuntimeException {

    /**
     *
     * Исключение, которое выбрасывается в случае попытки добавить в базу данных регион,
     * который уже существует в базе.
     */

    public RegionIdExistException() {
        super("Регион с таким id уже существует");
    }

}
