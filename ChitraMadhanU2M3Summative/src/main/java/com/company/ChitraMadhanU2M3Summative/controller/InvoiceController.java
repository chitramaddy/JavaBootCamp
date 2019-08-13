package com.company.ChitraMadhanU2M3Summative.controller;

import com.company.ChitraMadhanU2M3Summative.exception.InputValidationException;
import com.company.ChitraMadhanU2M3Summative.exception.NotFoundException;
import com.company.ChitraMadhanU2M3Summative.service.GameStoreService;
import com.company.ChitraMadhanU2M3Summative.viewModel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class InvoiceController {

    @Autowired
    GameStoreService gameStoreService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel addInvoice(@RequestBody @Valid InvoiceViewModel invoiceViewModel) throws InputValidationException {
        invoiceViewModel = gameStoreService.saveInvoice(invoiceViewModel);

        if (invoiceViewModel == null)
            throw new InputValidationException("Invoice could not be created.");
        System.out.println("Invoice getting created");
        return invoiceViewModel;
    }

    @GetMapping("/invoice/{invoiceId}")
    @ResponseStatus(HttpStatus.OK)
    public InvoiceViewModel getGame(@PathVariable("invoiceId") int invoiceId) {
        InvoiceViewModel invoiceViewModel = gameStoreService.findInvoice(invoiceId);
        if (invoiceViewModel == null)
            throw new NotFoundException("Invoice could not be retrieved for id " + invoiceId);
        return invoiceViewModel;
    }

}
