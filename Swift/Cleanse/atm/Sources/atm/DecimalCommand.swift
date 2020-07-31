//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 31/07/2020.
//

import Foundation

protocol DecimalCommand : SingleArgCommand {
    
    func handle(amount: Decimal) -> Result
    
}

extension DecimalCommand {
    
    func handle(arg: String) -> Result {
        
        if let d = Decimal(string: arg) {
            return handle(amount: d)
        }
        
        return Result.invalid()
    }
}
