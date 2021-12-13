import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class SolutionTests{
PrescriptionService ps = new PrescriptionService(new DoctorRepository(), new DrugRepository());

@Test
public void should_populateCorrectDoctorName() throws Exception {
Order order = new Order("Chris", 100, 1, 1);
Order order2 = new Order("James", 200, 2, 3);
PrescriptionOrderForm pof = ps.fillOrder(order);
PrescriptionOrderForm pof2 = ps.fillOrder(order2);
assertEquals("Smith", pof.getDoctorName());
assertEquals("Tonna", pof2.getDoctorName());
}

    @Test
public void should_populateCorrectDrugName() throws Exception {
Order order = new Order("Chris", 100, 1, 1);
Order order2 = new Order("James", 200, 2, 3);
PrescriptionOrderForm pof = ps.fillOrder(order);
PrescriptionOrderForm pof2 = ps.fillOrder(order2);
assertEquals("Tylenol", pof.getDrugName());
assertEquals("Asprin", pof2.getDrugName());
}

      @Test
public void should_populateCorrectPatientName() throws Exception {
Order order = new Order("Chris", 100, 1, 1);
Order order2 = new Order("James", 200, 2, 3);
PrescriptionOrderForm pof = ps.fillOrder(order);
PrescriptionOrderForm pof2 = ps.fillOrder(order2);
assertEquals("Chris", pof.getPatientName());
assertEquals("James", pof2.getPatientName());
}

        @Test
public void should_populateCorrectDosage() throws Exception {
Order order = new Order("Chris", 100, 1, 1);
Order order2 = new Order("James", 200, 2, 3);
PrescriptionOrderForm pof = ps.fillOrder(order);
PrescriptionOrderForm pof2 = ps.fillOrder(order2);
assertEquals(40, pof.getDosage(), 0.0);
assertEquals(250, pof2.getDosage(), 0.0);
}
}