package org.chintanpatel.pms.status;

import java.util.List;

public interface StatusService {

    void addStatus(Status status);

    List<Status> getStatusList();

    Status getStatusById(Long statusId);

    void deleteStatusById(Long statusId);

    List<Status>searchByStatusType(String statusType);
}
