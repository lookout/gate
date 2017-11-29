package com.netflix.spinnaker.gate.services

import com.netflix.spinnaker.gate.services.internal.ClouddriverService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class EcsClusterService {

  ClouddriverService clouddriver

  @Autowired
  EcsClusterService(ClouddriverService clouddriver) {
    this.clouddriver = clouddriver
  }

  List getAllEcsClusters() {
    clouddriver.getAllEcsClusters()
  }
}
