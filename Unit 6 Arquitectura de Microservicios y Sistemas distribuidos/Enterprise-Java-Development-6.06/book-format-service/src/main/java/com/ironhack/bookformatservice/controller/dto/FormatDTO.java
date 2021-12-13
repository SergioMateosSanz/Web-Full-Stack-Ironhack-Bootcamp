package com.ironhack.bookformatservice.controller.dto;

import java.util.List;

public class FormatDTO {

    private List<String> formatList;

    public FormatDTO() {
    }

    public List<String> getFormatList() {
        return formatList;
    }

    public void setFormatList(List<String> formatList) {
        this.formatList = formatList;
    }
}
