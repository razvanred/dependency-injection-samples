//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 31/07/2020.
//

import Foundation
import Cleanse

let COMMAND_KEY_WITHDRAW = "withdraw"

struct WithdrawCommand : DecimalCommand {
    
    private let account: Account
    private let outputter: Outputter
    
    private let minimumBalance: Decimal
    private let withdrawalLimiter: WithdrawalLimiter
    
    init(
        account: Account,
        outputter: Outputter,
        minimumBalance: TaggedProvider<MinimumBalance>,
        withdrawalLimiter: WithdrawalLimiter
    ) {
        self.account = account
        self.outputter = outputter
        self.minimumBalance = minimumBalance.get()
        self.withdrawalLimiter = withdrawalLimiter
    }
    
    var key: String { COMMAND_KEY_WITHDRAW }
    
    func handle(amount: Decimal) {
        if amount.sign == .minus {
            outputter.output("Cannot withdraw a negative amount")
            return
        }
        
        let remainingWithdrawalLimit = withdrawalLimiter.remainingWithdrawalLimit
        
        if amount > remainingWithdrawalLimit {
            outputter.output("You may not withdraw \(amount); you may withdraw \(remainingWithdrawalLimit) in this session")
            return
        }
        
        let newBalance = account.balance - amount
        
        if newBalance < minimumBalance {
            outputter.output("Minimum balance reached")
            return
        }
        
        account.withdraw(amount: amount)
        withdrawalLimiter.recordWithdrawal(amount: amount)
        outputter.output("Your new balance is: \(account.balance)")
    }
}
