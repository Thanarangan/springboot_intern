package com.example.springbootfirst.Service;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.models.UserDetailsDto;
import com.example.springbootfirst.repository.RegisterDetailsRepository;
import com.example.springbootfirst.services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private RegisterDetailsRepository registerDetailsRepository;

    @Test
    public void testAddEmployee() {

        UserDetailsDto employeeDto = new UserDetailsDto();
        employeeDto.setName("Vikas");
        employeeDto.setEmail("vikas@example.com");
        employeeDto.setPassword("1234");
        employeeDto.setUserName("vikas123");

        when(registerDetailsRepository.save(Mockito.any(RegisterDetails.class)))
                .thenReturn(new RegisterDetails());

        String result = employeeService.addEmployee(employeeDto);
        assertEquals("Employee added successfully", result);
    }
}
