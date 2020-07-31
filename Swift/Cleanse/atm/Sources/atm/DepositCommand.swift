//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 30/07/2020.
//

import Foundation

let COMMAND_KEY_DEPOSIT = "deposit"

struct DepositCommand : DecimalCommand {
    
    private let outputter: Outputter
    private let database: Database
    private let account: Account
    
    init(outputter: Outputter, database: Database, account: Account) {
        self.outputter = outputter
        self.database = database
        self.account = account
    }
    
    func handle(amount: Decimal) {
        account.deposit(amount: amount)
        outputter.output("\(account.username) now has: \(account.balance)")
    }
    
    var key: String { return COMMAND_KEY_DEPOSIT }
    
}
