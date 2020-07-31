//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 29/07/2020.
//

import Foundation

protocol NoArgsCommand : Command {
    
    func handle() -> Result
}

extension NoArgsCommand {
    func handle(input: [String]) -> Result {
        if !input.isEmpty {
            return Result.invalid()
        }
        return handle()
    }
}
