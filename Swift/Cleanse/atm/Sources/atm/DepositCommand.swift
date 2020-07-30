//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 30/07/2020.
//

import Foundation

let COMMAND_KEY_DEPOSIT = "deposit"

struct DepositCommand : Command {
    
    private let outputter: Outputter
    private let database: Database
    
    init(outputter: Outputter, database: Database) {
        self.outputter = outputter
        self.database = database
    }
    
    func handle(input: [String]) -> Status {
        if input.count != 2 {
            return Status.invalid
        }
        
        let account = database.getAccount(username: input[0])
        let optionalAmount = Decimal(string: input[1])
        
        if let amount = optionalAmount {
            account.deposit(amount: amount)
            outputter.output("\(account.username) now has: \(account.balance)")
            
            return Status.handled
        }
        
        return Status.invalid
    }
    
    var key: String { return COMMAND_KEY_DEPOSIT }
    
}
