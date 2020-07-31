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
    private let withdrawalLimiter: WithdrawalLimiter
    
    init(outputter: Outputter, database: Database, account: Account, withdrawalLimiter: WithdrawalLimiter) {
        self.outputter = outputter
        self.database = database
        self.account = account
        self.withdrawalLimiter = withdrawalLimiter
    }
    
    func handle(amount: Decimal) {
        account.deposit(amount: amount)
        withdrawalLimiter.recordDeposit(amount: amount)
        outputter.output("\(account.username) now has: \(account.balance)")
    }
    
    var key: String { COMMAND_KEY_DEPOSIT }
    
}
