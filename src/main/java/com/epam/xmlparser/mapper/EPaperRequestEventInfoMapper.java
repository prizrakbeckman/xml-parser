package com.epam.xmlparser.mapper;

import com.epam.xmlparser.model.entities.EPaper;
import com.epam.xmlparser.model.request.DeviceInfoType;
import com.epam.xmlparser.model.request.ScreenInfoType;
import org.springframework.stereotype.Service;

@Service
public class EPaperRequestEventInfoMapper {
    public EPaper mapEPaperRequestToEventInfo(DeviceInfoType deviceInfo,
                                              String filename,
                                              Double timeElapsed) {
        return buildEventInfoEntity(filename, timeElapsed, deviceInfo);
    }

    private EPaper buildEventInfoEntity(String filename, Double timeElapsed, DeviceInfoType deviceInfo) {
        EPaper ePaper = new EPaper();
        ePaper.setNewspaperName(getNewspaperName(deviceInfo));
        ePaper.setWidth(returnWidth(deviceInfo));
        ePaper.setHeight(returnHeight(deviceInfo));
        ePaper.setDpi(returnDpi(deviceInfo));
        ePaper.setFilename(filename);
        ePaper.setTimeElapsed(timeElapsed);
        return ePaper;
    }

    private Double returnDpi(DeviceInfoType deviceInfo) {
        String dpi = getScreenInfo(deviceInfo).getDpi();
        return Double.parseDouble(dpi);
    }

    private Double returnHeight(DeviceInfoType deviceInfo) {
        String height = getScreenInfo(deviceInfo).getHeight();
        return Double.parseDouble(height);
    }

    private Double returnWidth(DeviceInfoType deviceInfo) {
        String width = getScreenInfo(deviceInfo).getWidth();
        return Double.parseDouble(width);
    }

    private ScreenInfoType getScreenInfo(DeviceInfoType deviceInfo) {
        return deviceInfo.getScreenInfo();
    }

    private String getNewspaperName(DeviceInfoType deviceInfo) {
        return deviceInfo.getAppInfo().getNewspaperName();
    }
}
