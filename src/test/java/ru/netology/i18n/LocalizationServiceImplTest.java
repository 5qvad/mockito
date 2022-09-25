package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    private LocalizationServiceImpl localizationService;

    @BeforeEach
    void init(){
        localizationService = new LocalizationServiceImpl();
    }
    @Test
    void testMassageRus(){
        assertEquals(localizationService.locale(Country.RUSSIA),"Добро пожаловать");
    }

    @Test
    void testMassageEng(){
        assertEquals(localizationService.locale(Country.USA),"Welcome");
        assertEquals(localizationService.locale(Country.BRAZIL),"Welcome");
        assertEquals(localizationService.locale(Country.GERMANY),"Welcome");
    }



}