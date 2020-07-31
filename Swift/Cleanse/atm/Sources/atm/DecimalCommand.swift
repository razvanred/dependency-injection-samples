//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 31/07/2020.
//

import Foundation

protocol DecimalCommand : SingleArgCommand {
    
    func handle(amount: Decimal)
    
}

extension DecimalCommand {
    
    func handle(arg: String) -> Result {
        
        if let d = Decimal(string: arg) {
            handle(amount: d)
            return Result.handled()
        }
        
        return Result.invalid()
    }
}
