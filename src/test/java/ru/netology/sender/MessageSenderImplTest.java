package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.Map;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class MessageSenderImplTest {

    private MessageSenderImpl messageSender;
    private LocalizationServiceImpl localizationService;
    private GeoServiceImpl geoService;

    @BeforeEach
    void init() {
        localizationService = mock(LocalizationServiceImpl.class);
        geoService = mock(GeoServiceImpl.class);
        messageSender = new MessageSenderImpl(geoService, localizationService);
    }

    @Test
    void textRussian() {
        Location moscow = new Location("Moscow", Country.RUSSIA, null, 0);
        given(geoService.byIp("172.0.0.0")).willReturn(moscow);
        given(localizationService.locale(Country.RUSSIA)).willReturn("Привет");

        Assertions.assertEquals("Привет", messageSender.send(Map.of(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.0.0")));
    }

    @Test
    void textEnglish() {
        Location newYork = new Location("New York", Country.USA, null, 0);
        given(geoService.byIp("68.0.0.0")).willReturn(newYork);
        given(localizationService.locale(Country.USA)).willReturn("Hello");


    }


}