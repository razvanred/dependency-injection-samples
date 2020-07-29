//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 29/07/2020.
//

import Foundation

protocol NoArgsCommand : Command {
    
    func handle() -> Status
}

extension NoArgsCommand {
    func handleInput(input: [String]) -> Status {
        if !input.isEmpty {
            return Status.invalid
        }
        return handle()
    }
}
