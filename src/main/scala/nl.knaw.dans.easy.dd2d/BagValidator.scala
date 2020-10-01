/**
 * Copyright (C) 2020 DANS - Data Archiving and Networked Services (info@dans.knaw.nl)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
//package nl.knaw.dans.easy.dd2d
//
//import java.net.URI
//import java.nio.file.Path
//
//import nl.knaw.dans.lib.logging.DebugEnhancedLogging
//import scalaj.http.Http
//
//import scala.util.{ Failure, Try }
//
//class BagValidator(uri: URI) extends DebugEnhancedLogging {
//  private val validationUri = new URI(uri.getScheme, uri.getUserInfo, uri.getHost, uri.getPort, "validate", s"infoPackageType=SIP&uri=${bagDir.toUri}", null)
//
//
//  def checkConnection(): Try[Unit] = {
//    Try {
//      logger.info("Checking if validator service can be reached")
//      Http(s"${ validationUrlString }")
//        // TODO: Make timeouts configurable
//        .timeout(connTimeoutMs = 10000, readTimeoutMs = 10000)
//        .method("POST")
//        .header("Accept", "application/json")
//        .asString
//    } flatMap {
//      case r if r.code == 200 =>
//        DansBagValidationResult.fromJson(r.body)
//      case r =>
//        // TODO: THIS DOES NOT WORK. PLEASE TEST THAT FAILURES ACTUALLY GET PASSED UP.
//        Failure(new RuntimeException(s"Dans Bag Validation failed (${ r.code }): ${ r.body }"))
//    }
//    }
//  }
//
//  def validateBag(bagDir: Path): Try[DansBagValidationResult] = {
//    trace(bagDir)
//    Try {
//
//      logger.info(s"Calling Dans Bag Validation Service with ${ validationUrlString }")
//      Http(s"${ validationUrlString }")
//        // TODO: Make timeouts configurable
//        .timeout(connTimeoutMs = 10000, readTimeoutMs = 10000)
//        .method("POST")
//        .header("Accept", "application/json")
//        .asString
//    } flatMap {
//      case r if r.code == 200 =>
//        DansBagValidationResult.fromJson(r.body)
//      case r =>
//        // TODO: THIS DOES NOT WORK. PLEASE TEST THAT FAILURES ACTUALLY GET PASSED UP.
//        Failure(new RuntimeException(s"Dans Bag Validation failed (${ r.code }): ${ r.body }"))
//    }
//  }
//}