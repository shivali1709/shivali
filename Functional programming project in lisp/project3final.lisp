;List Functions


;Append
(defun append (list1 &optional list2)
       (if (null list1)
           list2  
           (if (null list2)
              list1
              (cons(car list1) (append(cdr list1)list2))
              )))

;Reverse
(defun reverse (list1)
      (if (null list1)
           nil
         (append(reverse(cdr list1)) (list (car list1)))))

;Map
(defun add3(x)
    (+ x 3))


(defun map (add3 list1)
  (if  (null list1)
         nil
     (cons(add3 (car list1) ) (map add3 (cdr list1)))))

;Duplicate
(defun nubhelper (list1 output)                                                                
    (if (eq list1 nil)                                                                              
        output
        (if (member (car list1) output)                                                          
            (nubhelper (cdr list1) output)
            (nubhelper (cdr list1) (cons (car list1) output))                                  
        )
    )
)

(defun nub (list1)                                                                              
    (reverse (nubhelper list1 nil))                                                      
)




;Filter
(defun lessthan3(x)
	(if(< x 3)
       x)
	)


(defun filter (lessthan3 list1)
	(if  (null list1)
         nil
     (if(lessthan3(car list1))
     	(cons(lessthan3(car list1)) (filter lessthan3 (cdr list1)))
     (filter lessthan3 (cdr list1)))))


;Add to end
(defun addtoend(x &optional list1)
    (reverse (cons x( reverse list1))))

;Index of
(defun indexcounter(x list1 i)
   (if(null list1)
     -1
	(if (eq (car list1) x)
        i
        (indexcounter x(cdr list1) (+ i 1 )))))

(defun indexof(x  list1)
    (indexcounter x list1 0)
)


;Set Functions

;Set Membership
(defun member(x &optional list1)
    (if (null list1) nil 
        (if (eql x (car list1)) t
            (member x (cdr list1)))))

;Insert Element into set
(defun insert(x &optional list1)
    (if (member x list1)
           list1
       (cons x list1)))

;Set intersection
(defun intersect (list1 &optional list2)
  (if (null list1) list1
    (if (member (car list1) list2)
      (cons (car list1) (intersect (cdr list1) list2))
      (intersect(cdr list1) list2))))

;Set union
(defun union (list1 &optional list2)
  (cond ((null list1) list2)
    ((member(car list1) list2) (union(cdr list1) list2))
    (t (cons (car list1) (union(cdr list1) list2)))))

;Set difference
(defun difference(list1 &optional list2)
  (cond ((null list1) nil)
        ((member (car list1) list2)
         (difference (cdr list1) list2))
        ((cons (car list1) (difference (cdr list1) list2)))))

;Symmetric Difference(Disjunctive Union)
(defun symdiff(list1 list2)
  ()
  )

;Check if it is a subset or equal
(defun subsetp(list1 &optional list2)
    (if(null list1)
        t
      (if(member(car list1) list2)
            (subsetp(cdr list1) list2)
           nil
      )
    )
)



;Cardinality
(defun counter(list1 i)
   (if(null list1)
     i
        (counter (cdr list1) (+ i 1 )))
)

(defun cardinality (list1)
    (counter list1 0)
)

;Power Set


;Math Functions

;Absolute Value
(defun abs (x)
  (if (< x 0)
       (* -1 x)
        x))

;Factorial
(defun factorial (x)
  (if (= x 0)
      1
      (* x (factorial (- x 1)))))

;Check if 3 lengths can make a right angled trianlge in the order entered.
(defun right-tri (x y z)

      (if(= (* z z ) (+ (* x x )(* y y )))
           t
           nil))

;GCD
(defun calculatemod(x i)
   (if (<= i x)
   (calculatemod x(+ i 1))
     (- i 1)
   )
)

(defun mod(x y)
	(if (< x y)
    	y
    	(- x (* y(calculatemod(/ x y)1))))
)


(defun gcd (x y)
  (if (= 0 y)
       x 
       (if (= 0 x)
          y
    (if (> x y)
      (gcd y (mod x y))
      (gcd x (mod y x))

      )))
  )

;LCM
(defun lcm (x y)
    (if (= 0 x) 
       (if (= 0 y)
          0
    (/(abs (* x y)) (gcd x y)))   
  (/(abs (* x y)) (gcd x y))
   
    )
    )




;Nth Fibonacci number 
(defun nth-fibo (x)
  (if(= x 0)
     0
  (if (= x 1)
      1
      (+ (nth-fibo(- x 1)) (nth-fibo(- x 2))))))


      (defun right-tri (x y z)

      (if(= (* z z ) (+ (* x x )(* y y )))
           t
           nil))

;Test if number is prime
(defun primechecker(x i)
    (if(>= i x)t
       (if (= (mod x i) 0)nil
       (primechecker x (+ i 1))
       )
    )
)
(defun prime (x)
    (if(< x 2)
       nil
  (primechecker x 2))
    )




;Required Functions
(defun factorsum(start next total list1)
	(if(< next 1) total
		(if(member(/ start next) list1)
			(factorsum start (- next 1) (+ total (/ start next))list1)
			(factorsum start (- next 1) total list1 ))))

(defun lessthanx(x list1)
	(if(< x 1) list1
	(lessthanx(- x 1) (cons x list1))))

(defun run (x)
	(factorsum x x 0 (lessthanx(- x 1)'(0))))

;Check if number is perfect
(defun perfectp(x)
	(if(= x (run x)) t nil))

;Check if number is abundant
(defun abundantp(x)
	(if(< x (run x)) t nil))

;Check if number is deficient
(defun deficientp(x)
	(if(> x (run x)) t nil))



(defun helper (function input1 input2 input3)                      
    (if (equalp (format nil "~a" input1) "end")
        nil
        (print-func function input1 input2 input3)
    )
)

(defun print-func (function input1 input2 input3)                 
    (if (eq input2 nil)
        (format t "(~a ~a) = ~a~%" function input1 (funcall function input1))
        (if (eq input3 nil)
            (format t "(~a ~a ~a) = ~a~%" function input1 input2 (funcall function input1 input2))
            (format t "(~a ~a ~a ~a) = ~a~%" function input1 input2 input3 (funcall function input1 input2 input3))
        )
    )
    t
)
  
;all repl functions

(defun append-repl ()
    (format t "Input two lists (type \"end end\" to quit): ")
      (finish-output nil)
    (if (helper 'append (read) (read) nil)
        (append-repl)
    )
)

(defun reverse-repl ()
    (format t "Input a list (type \"end\" to quit): ")
    (finish-output nil)
    (if (helper 'reverse (read) nil nil)
        (reverse-repl)
    )
)

(defun nub-repl ()
    (format t "Input a list (type \"end\" to quit): ")
    (finish-output nil)
    (if (helper 'nub (read) nil nil)
        (nub-repl)
    )
)

(defun map-repl ()
    (format t "Input 'add3' and a list of numbers (type \"end end\" to quit): ")
    (finish-output nil)
    (if (helper 'map (read) (read) nil)
        (nub-repl)
    )
)

(defun filter-repl ()
    (format t "Input a list of numbers (type \"end end\" to quit): ")
    (finish-output nil)
    (if (helper 'filter (read) (read) nil)
        (filter-repl)
    )
)

(defun addtoend-repl ()
    (format t "Input an element and a list (type \"end end\" to quit): ")
    (finish-output nil)
    (if (helper 'addtoend (read) (read) nil)
        (addtoend-repl)
    )
)

(defun indexof-repl ()
    (format t "Input an element and a list (type \"end end\" to quit): ")
    (finish-output nil)
    (if (helper 'indexof (read) (read) nil)
        (indexof-repl)
    )
)

(defun member-repl ()
    (format t "Input an element and a list (type \"end end\" to quit): ")
    (finish-output nil)
    (if (helper 'member (read) (read) nil)
        (member-repl)
    )
)

(defun insert-repl ()
    (format t "Input an element and a list (type \" end end\" to quit): ")
    (finish-output nil)
    (if (helper 'insert (read) (read) nil)
        (insert-repl)
    )
)

(defun intersect-repl ()
    (format t "Input two lists (type \"end end\" to quit): ")
    (finish-output nil)
    (if (helper 'intersect (read) (read) nil)
        (intersect-repl)
    )
)

(defun union-repl ()
    (format t "Input two lists (type \" end end \" to quit): ")
    (finish-output nil)
    (if (helper 'union (read) (read) nil)
        (union-repl)
    )
)

(defun difference-repl ()
    (format t "Input two lists (type \"end end \" to quit): ")
    (finish-output nil)
    (if (helper 'difference(read) (read) nil)
        (difference-repl)
    )
)
(defun subsetp-repl ()
    (format t "Input two lists (type \"end end \" to quit): ")
    (finish-output nil)
    (if (helper 'subsetp (read) (read) nil)
        (subsetp-repl)
    )
)

(defun cardinality-repl ()
    (format t "Input a list (type \"end\" to quit): ")
    (finish-output nil)
    (if (helper 'cardinality (read) nil nil)
        (cardinality-repl)
    )
)

(defun abs-repl ()
    (format t "Input a number (type \"end\" to quit): ")
    (finish-output nil)
    (if (helper 'abs (read) nil nil)
        (abs-repl)
    )
)

(defun factorial-repl ()
    (format t "Input a number (type \"end\" to quit): ")
    (finish-output nil)
    (if (helper 'factorial (read) nil nil)
        (factorial-repl)
    )
)

(defun right-tri-repl ()
    (format t "Input three numbers (type \"end end end \" to quit): ")
    (finish-output nil)
    (if (helper 'right-tri (read) (read) (read))
        (right-tri-repl)
    )
)

(defun gcd-repl ()
    (format t "Input two numbers (type \"end end\" to quit): ")
    (finish-output nil)
    (if (helper 'gcd (read) (read) nil)
        (gcd-repl)
    )
)

(defun lcm-repl ()
    (format t "Input two numbers (type \"end end\" to quit): ")
    (finish-output nil)
    (if (helper 'lcm (read) (read) nil)
        (lcm-repl)
    )
)

(defun nth-fibo-repl ()
    (format t "Input a number (type \"end\" to quit): ")
    (finish-output nil)
    (if (helper 'nth-fibo (read) nil nil)
        (nth-fibo-repl)
    )
)

(defun prime-repl ()
    (format t "Input a number (type \"end\" to quit): ")
    (finish-output nil)
    (if (helper 'prime (read) nil nil)
        (prime-repl)
    )
)
(defun perfectp-repl ()
    (format t "Input a number (type \"end\" to quit): ")
    (finish-output nil)
    (if (helper 'perfectp (read) nil nil)
        (perfectp-repl)
    )
)

(defun abundantp-repl ()
    (format t "Input a number (type \"end\" to quit): ")
    (finish-output nil)
    (if (helper 'abundantp (read) nil nil)
        (abundantp-repl)
    )
)


(defun deficientp-repl ()
    (format t "Input a number (type \"end\" to quit): ")
    (finish-output nil)
    (if (helper 'deficientp (read) nil nil)
        (deficientp-repl)
    )
)

  
  (defun replcall ()
    (format t "~%Append test~%")
    (append-repl)
    (format t "~%Reverse test ~%")
    (reverse-repl) 
    (format t "~%Remove Duplicates test~%")
    (nub-repl) 
    (format t "~% Map Add3 test~%")
    (map-repl) 
    (format t "~% Filterlessthan3 test~%")
    (filter-repl) 
    (format t "~% addtoend test~%")
    (addtoend-repl) 
    (format t "~% Indexof test~%")
    (indexof-repl)
    (format t "~%Member test~%") 
    (member-repl)
    (format t "~%Insert test~%")
    (insert-repl)
    (format t "~% Intersect test~%")
    (intersect-repl)
    (format t "~% Union test~%")
    (union-repl)
    (format t "~% Difference test~%")
    (difference-repl)
    (format t "~% Subset test~%")
    (subsetp-repl)
    (format t "~% Cardinality Test~%")
    (cardinality-repl)
    (format t "~% Absolute value test~%")
    (abs-repl)
    (format t "~% Factorial test~%")
    (factorial-repl)
    (format t "~%right-tri test~%")
    (right-tri-repl)
    (format t "~% Gcd test~%")
    (gcd-repl)
    (format t "~% lcm test~%")
    (lcm-repl)
    (format t "~% nth-fibo test~%")
    (nth-fibo-repl)
    
    (format t "~% Prime test~%")
    (prime-repl)
    (format t "~% Perfect test~%")
    (perfectp-repl)
    (format t "~% Abundant test~%")
    (abundantp-repl)
    (format t "~% Deficient test~%")
    (deficientp-repl)
)


  



  (defun main ()
        (print "LIST FUNCTIONS")
        (print "(APPEND (1 3 X A) (4 2 B))")
        (print(append '(1 3 X A) '(4 2 B)))
        (print "(REVERSE (A B C D))")
        (print(reverse '(A B C D)))
        (print "(MAP ADD3 (1 2 3 4))")
        (print(map 'add3 '(1 2 3 4 )))
        (print "(NUB (1 1 2 4 1 2 5))")
        (print (nub '(1 1 2 4 1 2 5)))
        (print"((FILTER LESSTHAN3 (1 4 5 2 1 6)))")
        (print(filter 'lessthan3 '(1 4 5 2 1 6)))
        (print "(ADDTOEND D (A B C))")
        (print(addtoend 'D '(A B C)))
        (print "(INDEXOF A (B C A D))")
        (print(indexof 'A '(B C A D)))
        (print "(INDEXOF A (B C D F))")
        (print(indexof 'A '(B C D F)))
        
        (print "SET FUNCTIONS")
  
        (print "(MEMBER A (B C A D))")
        (print(member 'A '(B C A D)))
        (print "(INSERT A (B C D))")
        (print(insert 'A '(B C D)))
        (print "(INSERT A (A B C D))")
        (print(insert 'A '(A B C D)))
        (print "(INTERSECTION (A B C) (A C D))")
        (print(intersect '(A B C) '(A C D)))
        (print "(UNION (A B C) (A C D))")
        (print(union '(A B C) '(A C D)))
        (print "(DIFFERENCE (A B C) (A C D))")
        (print(difference '(A B C) '(A C D)))
        (print "(DIFFERENCE (A C D) (A B C))")
        (print(difference '(A C D) '(A B C)))
        (print "(SUBSETP (A B) (A B C D)) ")
        (print(subsetp '(A B) '(A B C D)))
        (print "(SUBSETP (A B Q) (A B C D))")
        (print(subsetp '(A B Q) '(A B C D )))
        (print "(CARDINALITY (A B C))")
        (print(cardinality'(A B C)))
         
        (print "MATH FUNCTIONS")
        (print"(ABS 7)")
        (print(abs 7))
        (print"(ABS -7)")
        (print(abs -7))
        (print"(FACTORIAL 5)")
        (print(factorial 5))
        (print"(RIGHT-TRI 3 4 5)")
        (print(right-tri 3 4 5))
        (print"(RIGHT-TRI 1 2 3)")
        (print(right-tri 1 2 3))
        (print"(GCD 8 12)")
        (print(gcd 8 12))
        (print"(LCM 4 6)")
        (print(lcm 4 6))
        (print"(NTH-FIBO 6)")
        (print(nth-fibo 6))
        (print"(NTH-FIBO 10)")
        (print(nth-fibo 10))
        (print"(PRIMEP 1)")
        (print(prime 1))
        (print"(PRIMEP 2)")
        (print(prime 2))
        (print"(PRIMEP 4)")
        (print(prime 4))
        (print"(PRIMEP 10)")
        (print(prime 10))
        (print"(PRIMEP 11)")
        (print(prime 11))
        (print"(PRIMEP 101)")
        (print(prime 101))
        
        (print "REQ FUNCTIONS")
        (print"(PERFECTP 5)")
        (print(perfectp 5))
        (print"(PERFECTP 6)")
        (print(perfectp 6))
        (print"(PERFECTP 36)")
        (print(perfectp 36))
        (print"(PERFECTP 496)")
        (print(perfectp 496))
        (print"(ABUNDANTP 5)")
        (print(abundantp 5))
        (print"(ABUNDANTP 12)")
        (print(abundantp 12))
        (print"(DEFICIENTP 5)")
        (print(deficientp 5))
        (print"(DEFICIENTP 12)")
        (print(deficientp 12))
        )

      
      

(main) ; main()
  



