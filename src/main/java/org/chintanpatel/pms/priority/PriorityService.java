package org.chintanpatel.pms.priority;

import java.util.List;

public interface PriorityService {

    void addPriority(Priority priority);

    List<Priority> getPriorityList();

    Priority getPriorityById(Long priorityId);

    void deletePriorityById(Long priorityId);

    List<Priority>searchByPriorityType(String priorityType);
}
