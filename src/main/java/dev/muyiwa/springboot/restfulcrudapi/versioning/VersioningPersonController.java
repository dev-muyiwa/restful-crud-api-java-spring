package dev.muyiwa.springboot.restfulcrudapi.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    //    URI Versioning
    @GetMapping(path = "/v1/person")
    public PersonV1 getPersonV1() {
        return new PersonV1("John Doe");
    }

    @GetMapping(path = "/v2/person")
    public PersonV2 getPersonV2() {
        return new PersonV2(new Name("John", "Doe"));
    }

    //    Request Params Versioning
    @GetMapping(path = "/v1/person", params = "version=1")
    public PersonV1 getPersonV1Params() {
        return new PersonV1("John Doe");
    }

    @GetMapping(path = "/v2/person", params = "version=2")
    public PersonV2 getPersonV2Params() {
        return new PersonV2(new Name("John", "Doe"));
    }

    //    Request Header Versioning
    @GetMapping(path = "/v1/person", headers = "X-API-VERSION=1")
    public PersonV1 getPersonV1Headers() {
        return new PersonV1("John Doe");
    }

    @GetMapping(path = "/v2/person", headers = "X-API-VERSION=2")
    public PersonV2 getPersonV2Headers() {
        return new PersonV2(new Name("John", "Doe"));
    }

    //    Media-Type Versioning
    @GetMapping(path = "/v1/person", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getPersonV1Produces() {
        return new PersonV1("John Doe");
    }

    @GetMapping(path = "/v2/person", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getPersonV2Produces() {
        return new PersonV2(new Name("John", "Doe"));
    }
}
