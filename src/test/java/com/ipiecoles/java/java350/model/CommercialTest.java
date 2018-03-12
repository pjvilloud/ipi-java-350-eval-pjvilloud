package com.ipiecoles.java.java350.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CommercialTest {

    @Test
    public void testPrimeAnnuelleWithCANull(){
        //Given
        Commercial commercial = new Commercial();
        commercial.setCaAnnuel(null);

        //When
        Double prime = commercial.getPrimeAnnuelle();

        //Then
        Assertions.assertThat(prime).isEqualTo(500d);
    }

}
