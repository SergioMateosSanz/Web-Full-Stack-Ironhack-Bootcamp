import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.lang.annotation.Annotation;
import org.springframework.core.annotation.AnnotationUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.springframework.stereotype.Repository;
import java.lang.reflect.*;
import java.math.*;
import java.util.*;
import javax.validation.constraints.*;
import javax.validation.*;

public class RepositoryTesting {

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
  
    private MenuItem tester;
  
    @Before
    public void setUp() {
      tester = new MenuItem();
      tester.setId(1);
      tester.setName("Dropdown");
      tester.setPrice(new BigDecimal("14.00"));
      tester.setYear(1999);
    }

@Test
public void should_haveAllExpectedProperties() throws Exception{

      Field[] fields = MenuItem.class.getDeclaredFields();
      List al = Arrays.asList(fields); 
      
      assertEquals(4, al.size());
      assertNotNull(MenuItem.class.getDeclaredField("id"));
      assertNotNull(MenuItem.class.getDeclaredField("name"));
      assertNotNull(MenuItem.class.getDeclaredField("price"));
      assertNotNull(MenuItem.class.getDeclaredField("year"));

    }


@Test
public void shouldNot_allowNullProperties() throws Exception{
assertTrue(MenuItem.class.getDeclaredField("id").isAnnotationPresent(NotNull.class));
assertTrue(MenuItem.class.getDeclaredField("name").isAnnotationPresent(NotNull.class));
assertTrue(MenuItem.class.getDeclaredField("price").isAnnotationPresent(NotNull.class));
assertTrue(MenuItem.class.getDeclaredField("year").isAnnotationPresent(NotNull.class));
}


     @Test
    public void should_onlyAllowFourDigitsOnYear() throws Exception{
      assertTrue(MenuItem.class.getDeclaredField("year").isAnnotationPresent(Digits.class));
      
      tester.setYear(99999);
      Set<ConstraintViolation<MenuItem>> constraintViolations = validator.validate(tester);
      assertFalse(constraintViolations.isEmpty());
    }
  
    @Test
    public void shouldNot_onlyAllowPriceGreaterThanMax() throws Exception{
      assertTrue(MenuItem.class.getDeclaredField("price").isAnnotationPresent(DecimalMax.class));
      
      Set<ConstraintViolation<MenuItem>> constraintViolations = validator.validate(tester);
      assertTrue(constraintViolations.isEmpty());
      
      tester.setPrice(new BigDecimal("18.51"));
      constraintViolations = validator.validate(tester);
      assertFalse(constraintViolations.isEmpty());
    }




}