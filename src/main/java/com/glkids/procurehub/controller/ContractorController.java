package com.glkids.procurehub.controller;

import com.glkids.procurehub.dto.ContractorDTO;
import com.glkids.procurehub.dto.QuotationDTO;
import com.glkids.procurehub.entity.Contractor;
import com.glkids.procurehub.entity.QuotationMtrl;
import com.glkids.procurehub.service.AgreementService;
import com.glkids.procurehub.service.ContractorService;
import com.glkids.procurehub.service.QuotationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 계약 관리 메뉴 컨트롤러
 */
@RequestMapping("/contractor")
@Controller
@RequiredArgsConstructor
public class ContractorController {

    private final ContractorService contractorService;
    private final QuotationService quotationService;
    private final AgreementService agreementservice;
    /**
     * 업체 목록
     */
    @GetMapping("/list")
    public String List(Model model, ContractorDTO contractorDTO) {
        model.addAttribute("title", "업체 목록");

        model.addAttribute("contractorList", contractorService.list());


        return "/contractor/list";
    }

    /**
     * 업체 상세정보
     *
     * @param corno 사업자 등록 번호
     * @return /contractor/get 을 요청하여 업체 상세페이지를 표시합니다.
     */
    @GetMapping("/read")
    public String read(Long corno, Integer quotationPage, Model model) {
        model.addAttribute("title", "업체 정보");

        model.addAttribute("contractorRead", contractorService.read(corno));
        model.addAttribute("quotationList", contractorService.quoListByContractor(corno, 0));
        return "/contractor/read";
    }

    /**
     * 업체 등록 화면
     */
    @GetMapping("/register")
    public void getRegister(ContractorDTO contractorDTO, Model model) {
        model.addAttribute("title", "업체 등록");
    }

    /**
     * 업체 등록 처리
     */
    @PostMapping("/register")
    public String postRegister(ContractorDTO contractorDTO) {
        contractorService.register(contractorDTO);
        return "redirect:/contractor/list";
    }

    /**
     * 업체 수정 화면
     */
    @GetMapping("/update")
    public String getUpdate(Long corno, Model model) {
        model.addAttribute("title", "업체 수정");

        ContractorDTO dto = contractorService.read(corno);
        model.addAttribute("updateread", dto);

        return "/contractor/update";
    }

    /**
     * 업체 수정 처리
     */
    @PostMapping("/update")
    public String postUpdate(@ModelAttribute ContractorDTO contractorDTO) {
        contractorService.update(contractorDTO);
        return "redirect:/contractor/read?corno=" + contractorDTO.getCorno();
    }

    /**
     * 견적 목록
     */
    @GetMapping("/quolist")
    public String quoList(Model model) {
        model.addAttribute("title", "견적 목록");

        model.addAttribute("quotationList", contractorService.quoList());
        return "/contractor/quolist";
    }

    /**
     * 견적 등록
     */
    @GetMapping("/quoregister")
    public void getQuoRegister(Long corno, Model model) {
        model.addAttribute("title", "견적 등록");

    }

    /**
     * 견적 등록 처리
     */
    @PostMapping("/quoregister")
    public String postQuoRegister(QuotationDTO quotationDTO, QuotationMtrl quotationMtrl) {
        contractorService.quoRegister(quotationDTO);
        return "/contractor/quolist";
    }

    /**
     * 견적 상세보기
     */
    @GetMapping("/quoread")
    public String quodatail(Long qtno, Model model) {
        model.addAttribute("title", "견적 정보");

        model.addAttribute("quotation", contractorService.quoread(qtno));
        model.addAttribute("quotationMtrlList", quotationService.readQuotationMtrlList(qtno));

        return "/contractor/quoread";
    }

}
