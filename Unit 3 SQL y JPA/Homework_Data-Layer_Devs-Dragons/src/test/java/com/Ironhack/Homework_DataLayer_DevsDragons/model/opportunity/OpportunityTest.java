package com.Ironhack.Homework_DataLayer_DevsDragons.model.opportunity;

import com.Ironhack.Homework_DataLayer_DevsDragons.enums.Status;
import com.Ironhack.Homework_DataLayer_DevsDragons.model.Opportunity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpportunityTest {

    Opportunity opportunity;

    @BeforeEach
    void setUp() {
        opportunity = new Opportunity();
    }

    @Test
    void changeOpportunityStatus_NotUpdate_InputSameActualStatus() {
        opportunity.setStatus(Status.OPEN);
        opportunity.changeOpportunityStatus(Status.OPEN);
        if (opportunity.getStatus() != Status.OPEN) {
            fail("Incorrect status updated");
        }
        opportunity.setStatus(Status.CLOSED_WON);
        opportunity.changeOpportunityStatus(Status.CLOSED_WON);
        if (opportunity.getStatus() != Status.CLOSED_WON) {
            fail("Incorrect status updated");
        }
        opportunity.setStatus(Status.CLOSED_LOST);
        opportunity.changeOpportunityStatus(Status.CLOSED_LOST);
        if (opportunity.getStatus() != Status.CLOSED_LOST) {
            fail("Incorrect status updated");
        }
    }

    @Test
    void changeOpportunityStatus_CorrectUpdate_InputDifferentActualStatus() {
        opportunity.setStatus(Status.OPEN);
        opportunity.changeOpportunityStatus(Status.CLOSED_WON);
        if (opportunity.getStatus() != Status.CLOSED_WON) {
            fail("Incorrect status updated");
        }
        opportunity.changeOpportunityStatus(Status.CLOSED_LOST);
        if (opportunity.getStatus() != Status.CLOSED_LOST) {
            fail("Incorrect status updated");
        }
        opportunity.changeOpportunityStatus(Status.OPEN);
        if (opportunity.getStatus() != Status.OPEN) {
            fail("Incorrect status updated");
        }
        opportunity.changeOpportunityStatus(Status.CLOSED_LOST);
        if (opportunity.getStatus() != Status.CLOSED_LOST) {
            fail("Incorrect status updated");
        }
        opportunity.changeOpportunityStatus(Status.CLOSED_WON);
        if (opportunity.getStatus() != Status.CLOSED_WON) {
            fail("Incorrect status updated");
        }
        opportunity.changeOpportunityStatus(Status.OPEN);
        if (opportunity.getStatus() != Status.OPEN) {
            fail("Incorrect status updated");
        }
    }
}