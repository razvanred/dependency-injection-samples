//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 31/07/2020.
//

import Foundation
import Cleanse

struct AmountsModule : Module {

    static func configure(binder: Binder<Unscoped>) {
        binder
            .bind()
            .tagged(with: MinimumBalance.self)
            .to(value: Decimal.zero)
        
        binder
            .bind()
            .tagged(with: MaximumWithdrawal.self)
            .to(value: Decimal(1_000))
    }
}

struct MinimumBalance : Tag {
    typealias Element = Decimal
}

struct MaximumWithdrawal : Tag {
    typealias Element = Decimal
}
