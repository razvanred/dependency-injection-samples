//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 29/07/2020.
//

import Foundation

protocol SingleArgCommand : Command {
    
    func handle(arg: String) -> Result
    
}

extension SingleArgCommand {
    
    func handle(input: [String]) -> Result {
        
        if input.count != 1 {
            return Result.invalid()
        }
        
        return handle(arg: input[0])
    }
}
