package com.workwolf.docupload.resume;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Resume {
    @NotBlank(message = "File name is required")
    private String fileName;

    @NotNull(message = "File contents are required")
    private byte[] fileContents;

    public Resume(String originalFilename, byte[] bytes) {
        this.fileName = originalFilename;
        this.fileContents = bytes;
    }
}
