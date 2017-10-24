package com.netflix.spinnaker.gate.services

import com.netflix.spinnaker.gate.services.commands.HystrixFactory
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

  List getEcsClusters(String provider, String account, String region) {
    HystrixFactory.newListCommand("pipelines", "updatePipeline") {
      clouddriver.getEcsClusters(provider, account, region)
    } execute()
  }
}
