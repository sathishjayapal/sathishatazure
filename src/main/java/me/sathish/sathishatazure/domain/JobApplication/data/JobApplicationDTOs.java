package me.sathish.sathishatazure.domain.JobApplication.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobApplicationDTOs {
    private List<JobApplicationDTO> jobApplicationList;
    private long totalElements;
    private int totalPages;
    private int currentPage;
    @JsonProperty("isFirst")
    private boolean isFirst;
    @JsonProperty("isLast")
    private boolean hasLast;
    private boolean hasPrevious;

    public JobApplicationDTOs(Page<JobApplicationDTO> jobApplicationPage) {
        this.jobApplicationList = jobApplicationPage.getContent();
        this.setTotalElements(jobApplicationPage.getTotalElements());
        this.setTotalPages(jobApplicationPage.getTotalPages());
        this.setCurrentPage(jobApplicationPage.getNumber() + 1);
        this.setFirst(jobApplicationPage.isFirst());
        this.setHasLast(jobApplicationPage.isLast());
    }
}
