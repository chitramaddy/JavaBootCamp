package com.company.ChitraMadhanU1Capstone.controller;

import com.company.ChitraMadhanU1Capstone.exception.InputValidationException;
import com.company.ChitraMadhanU1Capstone.exception.NotFoundException;
import com.company.ChitraMadhanU1Capstone.service.GameStoreService;
import com.company.ChitraMadhanU1Capstone.viewModel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class InvoiceController {

    @Autowired
    GameStoreService gameStoreService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel addInvoice(@RequestBody @Valid InvoiceViewModel invoiceViewModel) throws InputValidationException {
        invoiceViewModel = gameStoreService.saveInvoice(invoiceViewModel);

        if (invoiceViewModel == null)
            throw new InputValidationException("Invoice could not be created.");
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
