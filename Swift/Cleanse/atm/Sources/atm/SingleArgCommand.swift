//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 29/07/2020.
//

import Foundation

protocol SingleArgCommand : Command {
    
    func handle(arg: String) -> Status
    
}

extension SingleArgCommand {
    
    func handle(input: [String]) -> Status {
        
        if input.count != 1 {
            return Status.invalid
        }
        
        return handle(arg: input[0])
    }
}
