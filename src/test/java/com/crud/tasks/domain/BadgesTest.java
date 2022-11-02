package com.crud.tasks.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BadgesTest {

    @Test
    void getAndSetFieldsTest() {

        //Given
        Badges badges = new Badges();

        //When
        badges.setVotes(23);
        AttachmentsByType attachments = new AttachmentsByType();
        badges.setAttachmentsByType(attachments);
        AttachmentsByType gotAttachmentsByType = badges.getAttachmentsByType();

        //Then
        Assertions.assertEquals(23, badges.getVotes());
        Assertions.assertEquals(attachments, gotAttachmentsByType);
    }
}