package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CigarPartyTest {

    @Test
    public void testHaveParty_ValidCigarsAndNotWeekend_ReturnsFalse() {
        // Arrange
        CigarParty cigarParty = new CigarParty();
        int cigars = 30;
        boolean isWeekend = false;

        // Act
        boolean result = cigarParty.haveParty(cigars, isWeekend);

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void testHaveParty_ValidCigarsAndNotWeekend_ReturnsTrue() {
        // Arrange
        CigarParty cigarParty = new CigarParty();
        int cigars = 50;
        boolean isWeekend = false;

        // Act
        boolean result = cigarParty.haveParty(cigars, isWeekend);

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void testHaveParty_ValidCigarsAndWeekend_ReturnsTrue() {
        // Arrange
        CigarParty cigarParty = new CigarParty();
        int cigars = 70;
        boolean isWeekend = true;

        // Act
        boolean result = cigarParty.haveParty(cigars, isWeekend);

        // Assert
        Assert.assertTrue(result);
    }


}