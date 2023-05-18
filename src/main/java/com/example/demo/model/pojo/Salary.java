package com.example.demo.model.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Document(collection = "Salary")
public class Salary {
    @Id
    private String id;
    @JsonProperty("Timestamp")
    private String timeStamp;
    @JsonProperty("Employer")
    private String employer;
    @JsonProperty("Location")
    private String location;
    @JsonProperty("Job Title")
    private String jobTitle;
    @JsonProperty("Years at Employer")
    private String yearsAtEmployer;
    @JsonProperty("Years of Experience")
    private String yearsOfExperience;
    @JsonProperty("Salary")
    private String salary;
    @JsonProperty("Signing Bonus")
    private String signingBonus;
    @JsonProperty("Annual Bonus")
    private String annualBonus;
    @JsonProperty("Annual Stock Value/Bonus")
    private String annualStockValue;
    @JsonProperty("Gender")
    private String gender;
    @JsonProperty("Additional Comments")
    private String comment;
}
