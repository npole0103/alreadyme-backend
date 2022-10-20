package kr.markdown.alreadyme.controller;

import kr.markdown.alreadyme.domain.dto.ReadmeItemDto.Create;
import kr.markdown.alreadyme.domain.dto.ReadmeItemDto.Request;
import kr.markdown.alreadyme.domain.dto.ReadmeItemDto.Download;
import kr.markdown.alreadyme.domain.dto.ReadmeItemDto.PullRequest;
import kr.markdown.alreadyme.domain.model.ReadmeItem;
import kr.markdown.alreadyme.service.AppService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/app")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AppController {
    public final AppService service;

    @PostMapping("readme")
    @ResponseStatus(HttpStatus.OK)
    public ReadmeItem post(@Valid @RequestBody Create createDto) throws Exception {
        return service.create(createDto);
    }

    @PostMapping("download")
    @ResponseStatus(HttpStatus.OK)
    public Download download(@Valid @RequestBody Request requestDto) throws Exception {
        return service.download(requestDto);
    }

    @PostMapping("pull-request")
    @ResponseStatus(HttpStatus.OK)
    public PullRequest pullRequest(@Valid @RequestBody Request requestDto) throws Exception {
        return service.pullRequest(requestDto);
    }
}

